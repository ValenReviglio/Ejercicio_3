function handleClick() {
    var data = $('form').serializeArray();
    var finalData = {};
    var url = "http://localhost:4567/agencias?"
    data.map(function (a) {
        finalData[a.name] = a.value;
    })
    $.ajax({
        url: "/client/getAgencies",
        data: finalData,
        success: function (resp) {
            renderAgencies(resp.data)
        }
    });
}

function renderAgencies(data) {
    console.log(data)
    $("form").remove();
    $("#button").remove();
    $("body").append(
        "<table id='agencies' class='table table-striped'>" +
        "  <thead>\n" +
        "    <tr>\n" +
        "      <th scope='col'>#</th>\n" +
        "      <th scope='col'>Nombre</th>\n" +
        "      <th scope='col'>Distancia</th>\n" +
        "      <th scope='col'>Dirección</th>\n" +
        "      <th scope='col'>Codigo de Agencia</th>" +
        "    </tr>\n" +
        "  </thead>" +
        "<tbody id='body'></tbody>" +
        "</table>"
    )

    for (i in data) {
        $("#body").append(
            "<tr>\n" +
                "<th>"+data[i].site_id+"</th>" +
                "<th>"+data[i].description+"</th>" +
                "<th>"+data[i].distance+"</th>" +
                "<th>"+data[i].address.address_line+"</th>" +
                "<th>"+data[i].agency_code+"</th>"+
                "<th>" +
                    "<button id="+data[i].agency_code+" type='button'' class='btn btn-success'>Guardar</button>" +
                "</th>"+
                "<th>" +
                    "<button id="+data[i].agency_code+"2 type='button'' class='btn btn-danger'>Eliminar</button>" +
                "</th>"+
            "</tr>\n"
        )
        $('#'+data[i].agency_code).click(function(){
            saveAgency(data[i])
        })
        $('#'+data[i].agency_code+"2").click(function(){
            deleteAgency(data[i].agency_code)
        })
    }

}

function saveAgency(agency) {
    console.log(agency)
    $.ajax({
        url: "/client/saveAgency",
        data: {agency: JSON.stringify(agency)},
        success: function (resp) {
            renderAgencies(resp.data)
        }
    });
}

function deleteAgency(agency_code) {
    $.ajax({
        url: "/client/saveAgency",
        data: agency_code,
        success: function (resp) {
            console.log(resp.data)
        }
    });
}