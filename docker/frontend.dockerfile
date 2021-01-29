FROM node:13.12.0-alpine as builder
#RUN mkdir -p /usr/src/app
RUN apk add --no-cache curl
WORKDIR /var/wwww
RUN npm install -g @angular/cli@8.3.25
COPY ./frontend-beneficiario /var/wwww
EXPOSE 4200
ENTRYPOINT ["ng", "serve", "--host", "0.0.0.0", "--port", "4200", "--proxy-config", "./angular.proxy.config.json"]