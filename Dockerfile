FROM ubuntu:latest 
RUN mkdir /app
COPY build/native/nativeCompile/echosrvr /app/echosrvr
EXPOSE 8080
CMD ["/app/echosrvr"]
