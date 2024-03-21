
$("#tree").treeview({
  collapsed: true,
  animated: "fast"
  });

  var dayManage = document.querySelector("#dayManage")

  dayManage.addEventListener("click", ()=>{
    var main = document.querySelector("#main");
    main.src = "adminHtml/roomAssignment.html"
  });
  var penaltyDetails = document.querySelector("#penaltyDetails")
  penaltyDetails.addEventListener("click", ()=>{
  var main = document.querySelector("#main");
  main.src = "adminHtml/penaltyDetails.html"
  });

  var Afloor = document.querySelector("#Afloor");
var Afloor2 = document.querySelector("#Afloor2")
var Afloor3 = document.querySelector("#Afloor3")

  Afloor.addEventListener("click", ()=>{
  var main = document.querySelector("#main");
  main.src = "adminHtml/A1F.html"
  });
  Afloor2.addEventListener("click", ()=>{
  var main = document.querySelector("#main");
  main.src = "adminHtml/A2F.html"
  });Afloor3.addEventListener("click", ()=>{
  var main = document.querySelector("#main");
  main.src = "adminHtml/A3F.html"
  });



