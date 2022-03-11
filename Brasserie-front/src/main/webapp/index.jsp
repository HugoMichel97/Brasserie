<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<title>Accueil</title>
    <main align="center">
      <h4> Connexion </h4>
      <form action="home" method="post">
        <table align="center">
        <tr>
          <td>Email :</td>
          <td> <input required placeholder="Email" name="mail" type="email"></td>
        </tr>

        <tr>
          <td>Password : </td>
          <td><input required placeholder="Password" name="password" pattern ="[A-z]{4,8}" type="password"></td>
        </tr>


        </table>
        <br>
        <div id="errorConnect">${error}</div>
        <br>
        <input value="Se connecter" type="submit">
      </form>
      <a href="inscription.jsp"> Inscription </a>
    </main>

