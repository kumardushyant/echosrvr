FROM ubuntu:latest
ADD ./build/native/nativeCompile/echosrvr /usr/sbin/echosrvr
EXPOSE 8080
CMD ["/usr/sbin/echosrvr"]