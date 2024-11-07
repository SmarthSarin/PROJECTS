import discord
import asyncio
from datetime import datetime, timedelta
import os

intents = discord.Intents.default()
intents.message_content = True

client = discord.Client(intents=intents)

study_sessions = {}

@client.event
async def on_ready():
    print(f'Logged in as {client.user}')

@client.event
async def on_message(message):
    if message.author == client.user:
        return

    if message.content.startswith('$start'):
        user_id = message.author.id
        if user_id in study_sessions:
            await message.channel.send("You already have a session running!")
        else:
            study_sessions[user_id] = {
                'start_time': datetime.now(),
                'paused': False,
                'total_study_time': timedelta(),
                'pause_time': None,
                'resume_time': None
            }
            await message.channel.send(f"Study session started at {study_sessions[user_id]['start_time'].strftime('%Y-%m-%d %H:%M:%S')}! I'll remind you to take a break in 40 minutes.")
            await remind_break(message, user_id)

    elif message.content.startswith('$pause'):
        user_id = message.author.id
        if user_id in study_sessions and not study_sessions[user_id]['paused']:
            study_sessions[user_id]['paused'] = True
            study_sessions[user_id]['total_study_time'] += datetime.now() - study_sessions[user_id]['start_time']

            # Calculate total study time in hours, minutes, and seconds
            total_time = study_sessions[user_id]['total_study_time']
            hours, remainder = divmod(total_time.total_seconds(), 3600)
            minutes, seconds = divmod(remainder, 60)

            await message.channel.send(f"Study session paused. Total study time: {int(hours)} hours {int(minutes)} minutes {int(seconds)} seconds.")

    elif message.content.startswith('$resume'):
        user_id = message.author.id
        if user_id in study_sessions and study_sessions[user_id]['paused']:
            study_sessions[user_id]['paused'] = False
            study_sessions[user_id]['start_time'] = datetime.now()
            study_sessions[user_id]['resume_time'] = datetime.now()
            await message.channel.send(f"Study session resumed at {study_sessions[user_id]['resume_time'].strftime('%Y-%m-%d %H:%M:%S')}.")
            await remind_break(message, user_id)

    elif message.content.startswith('$stop'):
        user_id = message.author.id
        if user_id in study_sessions:
            if not study_sessions[user_id]['paused']:
                study_sessions[user_id]['total_study_time'] += datetime.now() - study_sessions[user_id]['start_time']
            total_time = study_sessions[user_id]['total_study_time']
            hours, remainder = divmod(total_time.total_seconds(), 3600)
            minutes, seconds = divmod(remainder, 60)
            del study_sessions[user_id]
            await message.channel.send(f"Study session stopped. Total study time: {int(hours)} hours and {int(minutes)} minutes {int(seconds)} seconds.")
        else:
            await message.channel.send("No active study session to stop.")

    elif message.content.startswith('$commands'):
        commands_list = (
            "**$start**: Begin a study session. The bot will remind you to take a break after 40 minutes.\n"
            "**$pause**: Pause the current study session.\n"
            "**$resume**: Resume a paused study session.\n"
            "**$stop**: Stop the current study session and log the total study time.\n"
            "**$commands**: List all available commands and their descriptions.\n"
            "**$time**: Tell the current time."
        )
        await message.channel.send(commands_list)

    elif message.content.startswith('$time'):
        current_time = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        await message.channel.send(f"The current time is: {current_time}")

async def remind_break(message, user_id):
    await asyncio.sleep(40 * 60)  # 40 minutes
    if user_id in study_sessions and not study_sessions[user_id]['paused']:
        await message.channel.send("Time to take a 10-minute break!")
        await asyncio.sleep(10 * 60)  # 10 minutes
        if user_id in study_sessions and not study_sessions[user_id]['paused']:
            await message.channel.send("Break over! Let's get back to studying.")

client.run('Discord_token')