<?php
$login = isset($_POST['login']) ? $_POST['login'] : '';
$password = isset($_POST['password']) ? $_POST['password'] : '';

$login_attendu = 'admin';
$password_attendu = 'abcd'; // ou passer1234 selon le test

$message = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if ($login === $login_attendu && $password === $password_attendu) {
        $message = '<div style="background:#d4edda;color:#155724;padding:10px;border-radius:5px;margin-bottom:10px;">Connexion réussie</div>';
    } else {
        $message = '<div style="background:#f8d7da;color:#721c24;padding:10px;border-radius:5px;margin-bottom:10px;">Échec de la connexion</div>';
    }
}
?>

<div style="max-width:400px;margin:40px auto;padding:30px;border-radius:12px;background:#fff;box-shadow:0 2px 8px #0001;">
    <h1 style="text-align:center;">Connexion</h1>
    <?php echo $message; ?>
    <form method="post">
        <label>Login<br><input type="text" name="login" style="width:100%;padding:8px;margin-bottom:10px;"></label>
        <label>Password<br><input type="password" name="password" style="width:100%;padding:8px;margin-bottom:20px;"></label>
        <button type="submit" style="width:100%;padding:10px;background:#007bff;color:#fff;border:none;border-radius:5px;font-size:1.1em;">Se connecter</button>
    </form>
</div>