
// Get the input, button, and ul elements
const taskInput = document.getElementById("taskInput");
const addButton = document.getElementById("addButton");
const taskList = document.getElementById("taskList");

// Add event listener to button for adding tasks
addButton.addEventListener("click", function() {
if (taskInput.value !== "") {
 addTask(taskInput.value);
 taskInput.value = "";
}
});

// Add event listener to input element for adding tasks using Enter key
taskInput.addEventListener("keydown", function(event) {
if (event.key === "Enter" && taskInput.value !== "") {
 addTask(taskInput.value);
 taskInput.value = "";
}
});

// Function to add a new task
function addTask(task) {
const li = document.createElement("li");
li.className = "task-item";
li.innerHTML = `
 <span>${task}</span>
 <span class="delete-button" onclick="removeTask(this)">X</span>
`;
taskList.appendChild(li);
}

// Function to remove a task
function removeTask(taskElement) {
const listItem = taskElement.parentElement;
taskList.removeChild(listItem);
}