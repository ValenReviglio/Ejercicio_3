<%--
  Created by IntelliJ IDEA.
  User: vreviglio
  Date: 2019-04-26
  Time: 09:39
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <asset:stylesheet src="application.css"></asset:stylesheet>
    <asset:javascript src="application.js"></asset:javascript>
</head>

<body>
<asset:javascript src="client.js"></asset:javascript>
<form style=" margin: 10px; display: flex; flex-direction: column; align:center">
    <div style="display: flex; flex-direction: row;">
        <div>
            <div>
                <div class="form-group" style="margin: 20px;">
                    <label for="site">Site ID*</label>
                    <input type="text" class="form-control" name="site_id" id="site" aria-describedby="emailHelp">
                </div>

                <div>
                    <div class="form-group" style="margin: 20px;">
                        <label for="payment">Payment Method Id*</label>
                        <input type="text" class="form-control" name="payment_method_id" id="payment" aria-describedby="emailHelp">
                    </div>
                </div>
            </div>

            <div class="form-group" style="margin: 20px; display: flex; flex-direction: row">
                <div style="margin-right: 20px">
                    <label for="latitude">Latitude</label>
                    <input type="text" class="form-control" name="latitude" id="latitude" aria-describedby="emailHelp">
                </div>

                <div>
                    <label for="longitude">Longitude</label>
                    <input type="text" class="form-control" name="longitude" id="longitude" aria-describedby="emailHelp">
                </div>
            </div>

            <div class="form-group" style="margin: 20px;">
                <label for="criteria">Criterio de Orden</label>
                <select class="form-control" name="criteria" id="criteria">
                    <option value="address_line">Address Line</option>
                    <option value="agency_code">Agency Code</option>
                    <option value="distancia">Distance</option>
                </select>
            </div>

        </div>
    </div>
</form>

<div id="button"style="margin-left: 30px;">
    <button onclick="handleClick()" style="margin-right: 20px" class="btn btn-primary">Submit</button>
</div>
</body>
</html>