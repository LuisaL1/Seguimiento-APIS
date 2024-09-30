<%--
  Created by IntelliJ IDEA.
  User: Luisa
  Date: 30/09/2024
  Time: 9:54 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Consumo de Múltiples APIs</title>
    <style>
        body { font-family: Arial, sans-serif; }
        h1, h2 { color: #333; }
        pre { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
    </style>
</head>
<body>
<h1>Consumo de APIs</h1>

<h2>TRM - Tasa Representativa del Mercado</h2>
<pre><%= request.getAttribute("trmData") != null ? request.getAttribute("trmData") : "No se pudieron obtener los datos de TRM." %></pre>

<h2>Clima (WeatherStack API)</h2>
<pre><%= request.getAttribute("weatherData") != null ? request.getAttribute("weatherData") : "No se pudieron obtener los datos del clima." %></pre>

<h2>Rick and Morty API</h2>
<pre><%= request.getAttribute("rickMortyData") != null ? request.getAttribute("rickMortyData") : "No se pudieron obtener los datos de Rick and Morty." %></pre>

</body>
</html>
