# Prac Fix
**Prac Fix** is a small client-side mod for **Minecraft 1.8** that fixes inaccurate `/prac` positions on parkour servers.

## Features
- Fix inaccurate `/prac` positions
- Optional debug message when the mod updates your position


## The problem
Minecraft sends position updates on a **20-gametick timer** or when you move more than **~0.03 blocks**.

This means that if you move less than 0.03 blocks in your last tick before stopping, your server position won't be updated for another 20 ticks.
If you prac during this time, your prac position will be inaccurate.
Normally, you would either jump to force a position update or wait the 20 ticks before running `/prac`.


## How it works
The mod checks if you were moving last tick but not this tick.
It then compares your current position with your last reported position and checks if they're different.
If both conditions are met we send a position update
