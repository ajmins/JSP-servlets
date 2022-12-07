/**
 * 


function show(nr) {
    document.getElementById("tableView").style.display="none";
document.getElementById("table"+nr).style.display="block";
}
 */
 
function show() {
  var x = document.getElementById("tableView");
  if (x.style.display === "none") {
    x.style.display = "inline-block";
  } else {
    x.style.display = "none";
  }
}