# Use an official Node.js runtime as the base image
FROM node:14-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json files to the container
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the entire project to the container
COPY . .

# Build the React app for production
RUN npm run build

# Expose the desired port
EXPOSE 3000

# Set the command to run when the container starts
CMD ["npm", "start"]