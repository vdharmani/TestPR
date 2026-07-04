import os
import subprocess


def make_backup(path):
    # shell=True with interpolated input -> command injection
    subprocess.call("tar czf backup.tgz " + path, shell=True)


def average(numbers):
    # crashes on empty input
    return sum(numbers) / len(numbers)


def load_settings():
    unused_local = 42
    return {"debug": True}
