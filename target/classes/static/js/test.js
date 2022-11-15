
$(document).ready(function(){
    var count = 0;
    $("p").click(function(){
        $(this).hide();
    });
    $('#image').change(function(){
        const file = this.files[0];
        console.log(file);
        if (file){
            let reader = new FileReader();
            reader.onload = function(event){
                console.log(event.target.result);
                $('#imgPreview').attr('src', event.target.result);
            }
            reader.readAsDataURL(file);
        }
    });
    $('#test').click(
        function (){
            // $('#files' + count).change(
            //     function (){
            //         alert('hello')
            //     }
            // )
            // if($('#files' + count).value == null){
            //     alert('hello')
            // }
            count ++;
            var input = $("<input>").attr("type", "file")
                .attr("capture", "camera")
                .attr("accept", "image/*")
                .attr("name", "files")
                .attr("id", "files" + count).hide();
            $('.form-group').append(input);
            $('#files' + count).files[0] = $('#id')
            // $('#files' + count).click();
        }
    );
});
// function test(){
//     alert('hello')
// }