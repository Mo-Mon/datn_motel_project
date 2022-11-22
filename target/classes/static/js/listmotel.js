$(document).ready(function(){
    $("#btnSearch").click(function(){
        $("#action").val("search");
        $("form").prop("action","/home");
        $("form").prop("method","get");
        $("form").submit();
    });
});