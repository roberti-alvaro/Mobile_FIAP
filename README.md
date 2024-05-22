Para logar na aplicação deverá usar: 

email : teste@gmail.com
senha: teste123

Após logado a tela inicial aparecerá um professor de exemplo, ao clicar curtir (botão verde) ou não curtir (botão vermelho) a tela irá mudar para a de nenhum professor encontrado, porque só há 1 professor cadastrado.
Ao clicar na lupa na barra inferior, terá acesso a página de busca avançada.

Para visualizar a notificação push:
- Enviar seu e-mail google para o e-mail roberti.alvaro@gmail.com para liberar envio da notificação push. OBS: Sem a liberação do seu e-mail para crir a notificação dará erro de acesso ao criar a notificação push.
- Clicar no botão curtir do professor da tela principal.
- No logcat do android studio, pegar o token gerado após a curtida no campo "FCM Token" exemplo: eHxcq4_CT4mDa_ZWriDxLb:APA91bFDO6XwSO9XQx38Vyxr5TQh5PYewwyUrtd2mxPN28CeIEFpsEwJsaGQnqN9HZGhkNQfQJ5J34Bh2eggjmgClTcxyGrEv7GY5KvtUdIllyTeoUHUvfyY5Rar2tP97RPVnU4HTQrU
- Abrir o Postman(Desktop), e importar o seguinte curl:
  
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
  
Na requisição HTTP criada, abra a aba de autorização e selecione a opção OAuth 2.0 e abrirá ao lado direito uma aba para configuração. Nessa aba colar as configurações abaixo:

Grant type: 
Authorization Code

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

Após essa configuração clicar no botão laranja em baixo "Get New Access Token". Uma janela para login no seu gmail abrirá, faça login, utilize o token gerado.

Agora na aba Body da requisição, coloque o token gerado no Logcat do android studio onde esta escrito "COLAR TOKEN LOGCAT AQUI" e clique em "Send" para enviar sua requisição HTTP no Postman.

Pronto! Uma notificação push de "match" entre o aluno e professor aparecerá no seu emulador android!! Lembrando que esta notificação está sendo enviada para o sistema operacional do dispositivo utilizando segurança OAuth 2.0, como uma notificação real e não um simples mock! 
