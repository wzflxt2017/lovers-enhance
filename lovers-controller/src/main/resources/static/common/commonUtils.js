/*start*/
/*需要配合layui使用*/
var retData;
function getRetData(){
    return retData;
}

function closeSelf(){
    //当你在iframe页面关闭自身时
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}
/*end*/


function isEmpty(data) {
    if(data==null||data==undefined||$.trim(data)=="null"||$.trim(data)==''){
        return true;
    }else{
        return false;
    }
}

function notEmpty(data) {
    if(data==null||data==undefined||$.trim(data)=="null"||$.trim(data)==''){
        return false;
    }else{
        return true;
    }
}


function notEmptyArray(data) {
    if(data!=null&&data!=undefined&&$.trim(data)!="null"&&data.length>0){
        return true;
    }else{
        return false;
    }
}

/**
 * url:图片路径(必填);
 * divId:要加载的标签id(必填);
 * imageWidth:默认为100px;
 * imageHeight:默认为100px;
 * imageIds:所需图片的id（以逗号分割);
 * urlType:默认为get请求;
 * success:回调函数
 *
 */
function loadImagesByIds(url,divId,imageIds,imageWidth,imageHeight,urlType,success){
    if(isEmpty(urlType)) urlType="get";
    if(isEmpty(imageWidth)) imageWidth="200";
    //if(isEmpty(imageHeight)) imageHeight="100";

    if(isEmpty(imageIds)){
        return;
    }
    var split = imageIds.split(",");
    for(var i in split){
        $.ajax({
            url:url,
            data:{
                imageId:split[i]
            },
            type:urlType,
            success:function(data){
                var imageLocalUrl = "/uploadFileById/"+data.forModule+"/"+data.fileId+"_"+data.fileFullName;
                $("#"+divId).append("<img src='"+imageLocalUrl+"' width='"+imageWidth+"px' style='margin: 5px;' />");
            }
        });
    }
}

function getImageUrl(imageId){
    var imageLocalUrl="";
    if(isEmpty(imageId)){
        return;
    }
    $.ajax({
        url:"/sys/file/loadImagesByIds",
        async:false,
        data:{
            imageId:imageId
        },
        type:"get",
        success:function(data){
            var url = "/uploadFileById/"+data.forModule+"/"+data.fileId+"_"+data.fileFullName;
            imageLocalUrl=url;
        }
    });
    return imageLocalUrl;
}

/*前往某个页面*/
function toPage(url) {
    location.href=url;
}