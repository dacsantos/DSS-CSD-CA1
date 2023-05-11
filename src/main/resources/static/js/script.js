// Confirm user delete 
var elems = document.getElementsByClassName('confirmDelete');
var confirmDel = function(e) {
	if (!confirm('Are you sure you want to remove this user?')) e.preventDefault();
};
for (var i = 0, l = elems.length; i < l; i++) {
	elems[i].addEventListener('click', confirmDel, false);
}

// Confirm changes made to the user
var elems = document.getElementsByClassName('confirmChanges');
var confirmEdit = function(e) {
	if (!confirm('Are you happy with your changes?')) e.preventDefault();
};
for (var i = 0, l = elems.length; i < l; i++) {
	elems[i].addEventListener('click', confirmEdit, false);
}

//Back button on update user page
function goBack() {
  window.history.back();
}