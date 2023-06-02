FROM --platform=linux/amd64 node:18-alpine3.17 AS builder

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

FROM nginx:1.22.1-alpine

WORKDIR /app
COPY --from=builder /app/build /usr/share/nginx/html
COPY front-nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 3000

CMD ["nginx", "-g", "daemon off;"]
