$(document).ready(function() {

    $('#listar').on('click',function(){
        let tabla = document.querySelector('#tabla')
        tabla.innerHTML = ''
        tabla.innerHTML = '<thead><tr><th scope="col">Codigo</th><th scope="col">Nombre</th><th scope="col">Apellido</th><th scope="col">Materias</th><th scope="col">Notas</th></tr></thead>'
        $.ajax({
            url: "http://localhost:8080/ListaDeEstudiantes",
            type: "GET",
            datype: "JSON",
            success:function(respuesta){
                console.log(respuesta)
                for (i = 0; i <= respuesta.length; i++){
                    tabla.innerHTML += '<tr><td>'+respuesta[i].codigo+'</td><td>' + 
                    respuesta[i].nombre+'</td><td>' +
                    respuesta[i].apellido+'</td><td>' + 
                    respuesta[i].materias+'</td><td>' +  
                    respuesta[i].notas+'</td></tr>'
                }
            }
        });
    });

    $('#enviar').on('click', function(){
        let datos = {
            codigo: parseInt($('#codigo').val()),
            nombre: $('#nombre').val(),
            apellido: $('#apellido').val(),
            materias: [
                $('#materia_a').val(),
                $('#materia_b').val(),
                $('#materia_c').val()
            ],
            notas: [
                parseFloat($('#nota_a').val()),
                parseFloat($('#nota_b').val()),
                parseFloat($('#nota_c').val())
            ]
        }
        let datosEnvio = JSON.stringify(datos)
        console.log(datosEnvio)
        $.ajax({
            url: "http://localhost:8080/AgregarEstudiantes",
            type: "POST",
            data: datosEnvio,
            contentType: "application/JSON",
            datatype: "JSON",
            success:function(respuesta){
                alert(respuesta)
            }
        });
    });

    $('#promedio').on('click', function(){
        let code = $('#buscar_code').val()
        $.ajax({
            url: "http://localhost:8080/PromedioNotas/"+code,
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                if (respuesta) {
                    $('#promedio_realizado').append("Promedio del Estudiante "+code+"<br>"+ respuesta + "<br>")
                } else {
                    alert("El estudiante no se encontro!")
                }
            }
        });
    });
});