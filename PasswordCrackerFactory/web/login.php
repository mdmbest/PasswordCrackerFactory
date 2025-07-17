<?php
$correctLogin = "admin";
$correctPassword = "passer1234";

if ($_POST['login'] === $correctLogin && $_POST['password'] === $correctPassword) {
    echo "Connexion réussie";
} else {
    echo "Échec de la connexion";
}
?>
