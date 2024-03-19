
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


