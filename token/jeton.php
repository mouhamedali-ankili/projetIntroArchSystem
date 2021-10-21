<?php
require_once 'cleveri.php';
require_once 'mecanisme.php';
// On crée le header
$header = [
    'typ' => 'JWT',
    'alg' => 'HS256'
];

// On crée le contenu (payload)
$payload = [
    'user_id' => 123,
    'roles' => [
        'ROLE_ADMIN',
        'ROLE_USER'
    ],
    'email' => 'bonjourtafa@demo.fr'
];


$jwt = new JWT();
$TOKEN = $jwt->generate($header,$payload,SECRET,60);
echo $TOKEN;


 /*echo $base64Hearder;
 echo '....';
 echo $base64Payload;
 echo '....';
 echo $secret;
 echo '....';
 echo $base64Signature;
echo '....';
echo $Jtoken;*/
