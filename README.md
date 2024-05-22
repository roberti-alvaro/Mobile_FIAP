Para logar na aplicação deverá usar: 

email : teste@gmail.com
senha: teste123

**colocar pra clicar no curtir
**olhar no logcat o token gerado apos a curtida no campo "FCM Token". exemplo: eHxcq4_CT4mDa_ZWriDxLb:APA91bFDO6XwSO9XQx38Vyxr5TQh5PYewwyUrtd2mxPN28CeIEFpsEwJsaGQnqN9HZGhkNQfQJ5J34Bh2eggjmgClTcxyGrEv7GY5KvtUdIllyTeoUHUvfyY5Rar2tP97RPVnU4HTQrU

Para enviar as notificações para o APP no POSTMAN(Desktop):

Importar no POSTMAN:

curl --location 'https://fcm.googleapis.com/v1/projects/allone-hml/messages:send' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer ya29.a0AXooCgt1JU1jqyORhi2Z2VaUO8EXkucBVqKP6hBMIP3RNJnseOGE2wzlCumwyjJOtMD6lBhq0RR-rshKjRyYJR21iCjJB7jrscA4-XUrqRzD5fBfXAd3iAksgMF_rVzQCBlKiILyQaXEdIOOX0YmnSdPd6qawNKTH-xmaCgYKASUSARISFQHGX2MiucFtuJUSCjpy7apQWUVyHA0171' \
--data '{
"message":{
"token": "COLAR TOKEN LOGCAT AQUI",
"notification": {
"title": "Seu professor aceitou sua solitação",
"body": "O professor escolhido por você te aceitou em uma turma, clique para mais detalhes"
}
}
}'

**enviar seu e-mail google para o e-mail roberti.alvaro@gmail.com para liberar envio da notificação push. OBS: Sem a liberação do seu e-mail dará erro ao criar a notificação push.

On the created request open Authorization tab, and select type: OAuth 2.0. Click Configure New Token if available, on the right pane. After that, select for
Grant Type— Authorization Code.

Callback URL:
https://oauth.pstmn.io/v1/callback

Auth URL:
https://accounts.google.com/o/oauth2/v2/auth?access_type=offline

Access Token URL:
https://oauth2.googleapis.com/token

Client ID:
894875794357-dqlpopb250ctrln5vp1qqff0flg0cilg.apps.googleusercontent.com

Client Secret:
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

Scope:
https://www.googleapis.com/auth/firebase.messaging

** Após essa configuração clicar em post no postman.
** falar sobre a segurança Oauth2 do google, e que a notificação esta indo direto pro sistema operacional do dispositivo.
