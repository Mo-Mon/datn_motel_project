$(document).ready(function(){
    $("#btnSearch").click(function(){
        $("#action").val("search");
        $("form").prop("action","/home");
        $("form").prop("method","get");
        $("form").submit();
    });
    $(".btn-paging-click").click(function (){
        $("#pageCurrent").val($(this).val());
        $("#action").val("paging");
        $("form").prop("action","/home");
        $("form").prop("method","get");
        $("form").submit();
    })
});