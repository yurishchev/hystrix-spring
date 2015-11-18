<%@page session="false" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Hystrix-Spring Integration Sample</title>
</head>

<body>
<div>

    <ul>
        <li><a href="./failfast.html">Fail Fast Demo</a>.
        <li><a href="./failsilent.html">Fail Silent Demo</a>.
        <li><a href="./failstatic.html">Static Fallback Demo</a>.
        <li><a href="./fallbackvianetwork.html">Fallback Via Network Demo</a>.
        <li><a href="./hystrixdemo.html">Original Hystrix Demo</a>.
    </ul>

    <p>
        Real-Time stream is available at <a href="./hystrix.stream">./hystrix.stream</a>.
    </p>
    <p>
         <a href="//localhost:7979/hystrix-dashboard">Hystrix Dashboard</a>.
    </p>
</div>
</body>
</html>