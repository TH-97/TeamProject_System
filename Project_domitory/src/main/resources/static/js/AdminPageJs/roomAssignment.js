var table = document.querySelector("#ListTable");
table.addEventListener("click", ()=>{
    if(event.target.tagName != "TD")
        return;
    var  gndr_nm= event.target.parentElement.children[2].innerText;
    console.log(gndr_nm);
    var main = document.querySelector("#main")
    console.log(main)
    main.setAttribute('src', `/buildingFloor?gndr_nm=${gndr_nm}`);

});