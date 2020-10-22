# Shadow CLJS with Ant Design

Taking Shadow CLJS for a spin, a fresh take on web apps with the (React-based) 
Ant Design components and Clojurescript.

It shows:

- Shadow CLJS
- ClojureScript
- Re-frame / Reagent
- Continuous testing in the browser
- Ant Design components
- Ant Design Charts


The project is set up so that VSCode can use Remote Containers ("Dev Container") to run 
Shadow CLJS and the node server inside a Docker container.

Note how `.devcontainer\devcontainer.json` mounts the `.shadow-cljs` and `node_modules` 
directories on a file system insde the container to speed up the build dramatically.

Once the Docker container with the environment is running, install the NPM packages and 
run the the application from a terminal in the container:

```
    npm install
    npm run copy
    shadow-cljs watch app
```

Now browse to http://localhost:8700 to see the app.
It has "hot reloading" and will update when you change the source.


The app also provides continuous testing in the browser, just run the tests:

```
    shadow-cljs watch test
```

You can now open http://localhost:8021 to see the test results.
It conveniently provides a red/green icon in the browser tab while you are working, 
so you can see the status without opening the tab.




