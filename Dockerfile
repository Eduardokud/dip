FROM node:lts-alpine3.12
WORKDIR /opt/app
COPY Gate-simulator .
RUN npm install
CMD ["npm", "start"]
EXPOSE 9999