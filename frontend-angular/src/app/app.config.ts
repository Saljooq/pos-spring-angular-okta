const { CLIENT_ID, ISSUER, OKTA_TESTING_DISABLEHTTPSCHECK} = process.env;

const BACKEND_URI = 'http://localhost:8080';
const FRONTEND_URI = 'http://localhost:4200';

export default {
  oidc: {
    clientId: CLIENT_ID,
    issuer: ISSUER,
    redirectUri: `${FRONTEND_URI}/login/callback`,

    // redirectUri: 'http://localhost:4200/login/callback',
    scopes: ['openid', 'profile', 'email'],
    testing: {
      disableHttpsCheck: `${OKTA_TESTING_DISABLEHTTPSCHECK}`
    }
  },
  resourceServer: {
    messagesUrl: `${BACKEND_URI}/api/messages`,

    // messagesUrl: 'http://localhost:8080/api/messages',
  },
};
