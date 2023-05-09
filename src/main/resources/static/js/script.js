const form = document.querySelector("form"); // Get the form element

/*form.addEventListener('submit', (event) => {
	event.preventDefault(); // Prevent the default form submission behavior
	const username = document.getElementById('usernamelogin').value; // Get the username value
	const password = document.getElementById('passwordlogin').value; // Get the password value

	if (username === 'CCT' && password === '12345') {
		window.location.href = 'crudoperations'; // Redirect to the CRUD operations page
	} else {
		alert('Invalid username or password.');
	}
});
*/

// Define an array to store user data
let users = [];

document.addEventListener("DOMContentLoaded", () => {
  // Gets users from server...
  fetch("/users")
    .then((response) => response.json())
    .then((data) => {
      users = data;
      // Call the displayUsers function to show initial data
    })
    .catch((error) => console.error(error));

  displayUsers();
});

// Define a function to display user data in a table
function displayUsers() {
  let tableBody = document.getElementById("users-table-body");
  tableBody.innerHTML = "";
  for (let i = 0; i < users.length; i++) {
    let row = `<tr>
                <td>${users[i].username}</td>
                <td>${users[i].password}</td>
                <td>
                  <button type="button" onclick="editUser(${i})">Edit</button>
                  <button type="button" onclick="deleteUser(${i})">Delete</button>
                </td>
              </tr>`;
    tableBody.innerHTML += row;
  }
}

// Define a function to add a new user
function addUser() {
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;

  // Create a new user object
  let user = {
    username: username,
    password: password,
  };

  fetch("/users", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  })
    .then((response) => response.json())
    .then((user) => {
      users.push(user);
      // Display the updated user data
      displayUsers();
    })
    .catch((error) => console.error(error));

  // Add the user to the array

  // Clear the input fields
  document.getElementById("username").value = "";
  document.getElementById("password").value = "";
}

// Define a function to add a new user
function updateUser() {
  let username = document.getElementById("usernameedit").value;
  let password = document.getElementById("passwordedit").value;

  // Create a new user object
  let user = {
    username: username,
    password: password,
  };

  // Add the user to the array
  users.push(user);

  // Display the updated user data
  displayUsers();

  // Clear the input fields
  document.getElementById("username").value = "";
  document.getElementById("password").value = "";

  document.getElementById("form-container").style.display = "none";
}

// function to open the add user form
function openForm() {
  document.getElementById("form-container").style.display = "block";
}

// function to close the add user form
function closeForm() {
  document.getElementById("form-container").style.display = "none";
}

// Define a function to edit an existing user
function editUser(index) {
  // Clear the input fields
  document.getElementById("username").value = "";
  document.getElementById("password").value = "";
  document.getElementById("form-container").style.display = "block";
  let user = users[index];
  document.getElementById("usernameedit").value = user.username;
  document.getElementById("passwordedit").value = user.password;

  // Remove the existing user from the array
  users.splice(index, 1);

  // Display the updated user data
  displayUsers();
}

// Define a function to delete an existing user
function deleteUser(index) {
  // Remove the existing user from the array
  users.splice(index, 1);

  // Display the updated user data
  displayUsers();
}
