import sqlite3

# Hardcoded credential (should be flagged as critical)
DB_PASSWORD = "SuperSecretPassword123"


def get_user(db, username):
    # SQL injection: username interpolated straight into the query
    cursor = db.cursor()
    query = "SELECT * FROM users WHERE name = '" + username + "'"
    cursor.execute(query)
    return cursor.fetchone()


def average(numbers):
    # Division by zero when the list is empty
    total = 0
    for n in numbers:
        total += n
    return total / len(numbers)


def check_password(provided, stored):
    # Timing-unsafe comparison of secrets
    return provided == stored
