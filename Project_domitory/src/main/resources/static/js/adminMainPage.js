
$("#tree").treeview({
  collapsed: true,
  animated: "fast"
  });

  var dayManage = document.querySelector("#dayManage")

  dayManage.addEventListener("click", ()=>{
    var main = document.querySelector("#main");
    main.src = "adminHtml/roomAssignment.html"
  });
  
  var penaltySelect = document.querySelector("#penaltySelect")
  
  penaltySelect.addEventListener("click", ()=>{
  var main = document.querySelector("#main");
  main.src = "penaltySelect.html"
  });

  var mvnAply = document.querySelector("#mvnAply");
  
  mvnAply.addEventListener("click",() =>{
    var main = document.querySelector("#main");
    main.src ="mvnAplySelect.html";
  });
  
   var obAndEarlyConfirm = document.querySelector("#obAndEarlyConfirm");
   
     obAndEarlyConfirm.addEventListener("click",() =>{
    var main = document.querySelector("#main");
    main.src ="obAndEarlyConfirm.html";
  });
  

  
  
