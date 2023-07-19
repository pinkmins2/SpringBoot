// pds view
let newpdsbtn = document.querySelector("#newpdsbtn")
newpdsbtn?.addEventListener('click', () => {
    location.href = '/pds/write';
});

let modpdsbtn = document.querySelector("#modpdsbtn")
modpdsbtn?.addEventListener('click', () => {
    if(confirm("정말 수정하시겠어요?")) {
        alert('아직 미지원 기능입니다!!');
    }
});

let rmvpdsbtn = document.querySelector("#rmvpdsbtn")
rmvpdsbtn?.addEventListener('click', () => {
    if(confirm("정말 삭제하시겠어요?")) {
        alert('아직 미지원 기능입니다!!');
    }
});

let lstpdsbtn = document.querySelector("#lstpdsbtn")
lstpdsbtn?.addEventListener('click', () => {
    history.back();
    //ocation.href = '/pds/list/1';
});


// pds write
let wrtpdsbtn = document.querySelector("#wrtpdsbtn")
wrtpdsbtn?.addEventListener('click', () => {
    let frm = document.forms.pdsfrm;
    if(frm.title.value === '') alert('제목을 작성하세요!!');
    else if(frm.contents.value === '') alert('본문을 작성하세요!!');
    else if(grecaptcha.getResponse() === '') alert('자동쓰기방지를 클릭하세요!!');
    else {
        frm.method = 'post';
        frm.enctype = 'multipart/form-data';    // 첨부기능을 위해 추가
        frm.submit();
    }
});

let cancelbtn3 = document.querySelector("#cancelbtn3")
cancelbtn3?.addEventListener('click', () => {
    history.back();
    //location.href = '/pds/list/1';
})


// pds find
let findbtn = document.querySelector("#findbtn")
let findtype = document.querySelector("#findtype")
let findkey = document.querySelector("#findkey")

findbtn?.addEventListener('click', () => {
    if(findkey.value === '') alert('검색어를 입력하세요!!')
    else {
        location.href = `/pds/find/${findtype.value}/${findkey.value}/1`;
    }
});

// pds comment
let newcmtbtn = document.querySelector("#newcmtbtn")
newcmtbtn?.addEventListener('click', ()=> {
   let frm = document.forms.cmtfrm;
   if(frm.userid.value === '') alert('로그인 하세요!!');
   else if(frm.pno.value === '') alert('로그인 하세요!!');
   else if(frm.comments.value === '') alert('댓글을 작성하세요!!');
   else{
       frm.method = 'post';
       frm.action = '/pds/cmt/write';
       frm.submit();
   }
});

// pds reply
let modal = null;
const refno = document.querySelector("#ref");
const showReply = (ref) => {
    refno.value = ref;    // 댓댓글을 작성할 댓글의 댓글번호(cno)를 알아냄
    modal = new bootstrap.Modal(replyModal, {});
    modal.show();
};

const replybtn = document.querySelector("#replybtn");
const frm = document.querySelector("#replyfrm")
replybtn?.addEventListener('click', () => {
    if(frm.comments.value === '') alert('대댓글을 작성하세요!!');
    else if(frm.ref.value === '') alert('댓글 번호가 없어요');
    else if(frm.pno.value === '') alert('본문글 번호가 없어요');
    else {
        frm.method = 'post';
        frm.action = '/pds/reply/write';
        frm.submit();
    }
});