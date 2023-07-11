
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.math.RoundingMode" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.IOException" %>

<%
    double principal = Double.parseDouble(request.getParameter("principal"));
    double interestRate = Double.parseDouble(request.getParameter("interest"));
    int time = Integer.parseInt(request.getParameter("time"));
    
    double monthlyInterest = interestRate / 1200; // Calculating monthly interest rate
    
    double emi = (principal * monthlyInterest * Math.pow(1 + monthlyInterest, time)) / (Math.pow(1 + monthlyInterest, time) - 1);
    double totalAmount = emi * time;

    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.CEILING);
%>

<!DOCTYPE html>
<html>
<head>
    <title>EMI Calculator - Result</title>
</head>
<body>
    <h2>EMI Calculation Result</h2>
    <table>
        <tr>
            <td>Principal Amount:</td>
            <td><%= df.format(principal) %></td>
        </tr>
        <tr>
            <td>Rate of Interest:</td>
            <td><%= df.format(interestRate) %></td>
        </tr>
        <tr>
            <td>Time (in months):</td>
            <td><%= time %></td>
        </tr>
        <tr>
            <td>EMI per Month:</td>
            <td><%= df.format(emi) %></td>
        </tr>
        <tr>
            <td>Total Amount:</td>
            <td><%= df.format(totalAmount) %></td>
        </tr>
    </table>
</body>
</html>
