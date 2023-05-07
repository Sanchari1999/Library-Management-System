// Toggle mobile menu
const menuBtn = document.querySelector('.menu-btn');
const mobileMenu = document.querySelector('nav ul');
menuBtn.addEventListener('click', () => {
mobileMenu.classList.toggle('show');
});

// Show/hide password
const passwordField = document.querySelector('#password');
const showPassBtn = document.querySelector('.show-password');
showPassBtn.addEventListener('click', () => {
if (passwordField.type === 'password') {
passwordField.type = 'text';
showPassBtn.textContent = 'Hide';
} else {
passwordField.type = 'password';
showPassBtn.textContent = 'Show';
}
});

// Confirm account deletion
const deleteBtn = document.querySelector('.delete-account');
deleteBtn.addEventListener('click', () => {
const confirmDelete = confirm('Are you sure you want to delete your account?');
if (confirmDelete) {
// handle account deletion
}
});
