$(document).ready(function(){
    $("#btnSearch").click(function(){
        alert("hdel")
        $("form").prop("action","/home/search");
        $("form").prop("method","get");
        $("form").submit();
    });
});