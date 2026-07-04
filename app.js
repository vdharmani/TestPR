// User service
function getUser(db, name) {
  // Builds SQL by concatenation -> SQL injection
  return db.query("SELECT * FROM users WHERE name = '" + name + "'");
}

function divide(a, b) {
  // No guard against b === 0
  return a / b;
}

async function fetchData(url) {
  // No response.ok check and no try/catch -> silent failures
  const res = await fetch(url);
  return res.json();
}

module.exports = { getUser, divide, fetchData };
