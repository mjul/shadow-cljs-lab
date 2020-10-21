# Shadow CLJS with Ant Design

Taking Shadow CLJS for a spin, a fresh take on web apps with the (React-based) 
Ant Design components and Clojurescript.

The project is set up so that VSCode can use Remote Containers ("Dev Container") to run 
Shadow CLJS and the node server inside a Docker container.

Once the Docker container with the environment is running, install the NPM packages and 
run the the application from a terminal in the container:

```
    npm install
    npm run copy
    shadow-cljs watch app
```

Now browse to http://localhost:8700 to see the app.
It has "hot reloading" and will update when you change the source.

