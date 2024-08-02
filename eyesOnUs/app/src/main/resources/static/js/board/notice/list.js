$.ajax({
    url:"/notice/listData",
    type:"get",
    success : (data)=>{
        console.log("목록 조회 성공");
        console.log(data);

        const list = document.querySelector(".box");

        let str = "";
        const voList = data.voList;

        for(let i = 0; i < voList.length; i++){
            str += "<tr class='list' data-id='" + voList[i].no + "'>";
            str += "<td>" + voList[i].no + "</td>";
            str += "<td>" + voList[i].title + "</td>";
            str += "<td>" + voList[i].enrollDate + "</td>";
            str += "<td>" + voList[i].writerNo + "</td>";
            str += "<td>" + voList[i].hit + "</td>";
            str += "</tr>"
        }

        list.innerHTML = str;

        document.querySelectorAll(".list").forEach((x)=>{
          x.addEventListener("click", ()=>{
            const no = x.getAttribute("data-id");
            location.href="/notice/detail?no="+no;
          });
        });
        updatePage(data.pageVo);
    },
    fail : ()=>{
        console.log("목록 조회 실패");
    },
});

function page(page){
    $.ajax({
        url : "/notice/listData",
        type : "get",
        data : {
        page : page ,
        size : 10
        },
        success : (data)=>{
            console.log("통신 성공");
            updateList(data);
        },
        fail : ()=>{
            console.log("통신 실패")
        }
    });
}

function updateList(data) {
    const list = document.querySelector(".box");

    let str = "";
    const voList = data.voList;

    for (let i = 0; i < voList.length; i++) {
        str += "<tr class='list' data-id='" + voList[i].no + "'>";
        str += "<td>" + voList[i].no + "</td>";
        str += "<td>" + voList[i].title + "</td>";
        str += "<td>" + voList[i].enrollDate + "</td>";
        str += "<td>" + voList[i].writerNo + "</td>";
        str += "<td>" + voList[i].hit + "</td>";
        str += "</tr>";
    }

    list.innerHTML = str;

    document.querySelectorAll(".list").forEach((x) => {
        x.addEventListener("click", () => {
            const no = x.getAttribute("data-id");
            location.href = "/notice/detail?no=" + no;
        });
    });
    updatePage(data.pageVo);
}

function updatePage(pageVo) {
    const pagination = document.querySelector("#page");
    let str = "";

    if (pageVo.prevPage > 0) {
        str += `<a onclick="page(${pageVo.prevPage})">이전&nbsp&nbsp</a>`;
    }

    for (let i = pageVo.min; i <= pageVo.max; i++) {
        str += `<a onclick="page(${i})">${i}&nbsp&nbsp</a>`;
    }

    if (pageVo.nextPage > 0) {
        str += `<a onclick="page(${pageVo.nextPage})">다음</a>`;
    }

    pagination.innerHTML = str;
}
