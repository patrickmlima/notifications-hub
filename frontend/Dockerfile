FROM node:20-slim AS build
WORKDIR /usr/src/app
COPY ./notifications-hub-fe/package*.json ./
RUN npm install
COPY ./notifications-hub-fe/ .
RUN npm run build -- --output-path=./dist/out --configuration production

FROM nginx:stable-alpine
COPY --from=build /usr/src/app/dist/out/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
