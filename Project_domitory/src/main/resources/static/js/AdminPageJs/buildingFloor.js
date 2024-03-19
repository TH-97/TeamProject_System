var table = document.querySelector("#ListTable");
table.addEventListener("click", ()=>{
    if(event.target.tagName != "TD")
        return;
    var  bldg_cd= event.target.parentElement.children[0].innerText;
    console.log(bldg_cd);
    var main = document.querySelector("#main")
    console.log(main)
    main.setAttribute('src', `/room?bldg_cd=${bldg_cd}`);

});