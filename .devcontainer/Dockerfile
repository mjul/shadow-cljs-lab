# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.140.1/containers/javascript-node/.devcontainer/base.Dockerfile

# [Choice] Node.js version: 14, 12, 10
ARG VARIANT="14-buster"
FROM mcr.microsoft.com/vscode/devcontainers/javascript-node:0-${VARIANT}

# [Optional] Uncomment this section to install additional OS packages.
# We need Open JDK for Shadow CLJS and Leiningen for templating:
RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends default-jdk-headless leiningen

# [Optional] Uncomment if you want to install an additional version of node using nvm
# ARG EXTRA_NODE_VERSION=10
# RUN su node -c "source /usr/local/share/nvm/nvm.sh && nvm install ${EXTRA_NODE_VERSION}"

# [Optional] Uncomment if you want to install more global node modules
# Install the Shadow CLJS tools so we can run `shadow-cljs` at the command-line:
RUN sudo -u node npm install -g shadow-cljs
