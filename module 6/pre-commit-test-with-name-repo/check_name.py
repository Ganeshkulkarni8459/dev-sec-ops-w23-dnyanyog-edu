#!/usr/bin/env python3
import subprocess

expectedName = "Ganesh Kulkarni"

Name = subprocess.run(["git", "config", "user.name"], capture_output=True, text=True).stdout.strip()

if Name == expectedName:

        print("You are using name as per configuration, proceeding to commit")
        exit(0)

else:
        print(f"Configured name is not as per config. It should be {expectedName}")
        exit(1)
