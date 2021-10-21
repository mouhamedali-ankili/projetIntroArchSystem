<?php 
class JWT
{
    public function generate(array $header ,array $payload ,string $secret, int $validite=86400): string 

    {
        if ($validite > 0) {
            $now =new DateTime();
            $expiration = $now->getTimestamp() + $validite;
            $payload['iat'] = $now->getTimestamp();
            $payload['exp'] = $expiration;
            
        }
         // on encode en base64
$base64Hearder = base64_encode(json_encode($header));
$base64Payload = base64_encode(json_encode($payload));

// on retire les +, / et  =
$base64Hearder = str_replace(['+','/','='],['-','_',''], $base64Hearder); 
$base64Payload = str_replace(['+','/','='],['-','_',''], $base64Payload); 
 // on genere la signature  
 $secret= base64_encode(SECRET); 
 $signature = hash_hmac('sha256',$base64Hearder.'.'.$base64Payload, $secret, true );
 $secret = str_replace(['+','/','='],['-','_',''], $secret);
 //  TWVkdXNhdG91dGFua2hhbU8 (cle a supprimer apres )
 $base64Signature= base64_encode($signature); 

 $base64Signature = str_replace(['+','/','='],['-','_',''],$base64Signature);


 // on cree le token 
 $Jtoken = $base64Hearder.'.'.$base64Payload.'.'.$base64Signature; 

  return $Jtoken;
    }
}