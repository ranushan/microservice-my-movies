Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/bionic64"
  config.vm.hostname = "mydocker"
  config.vm.network "private_network", ip: "192.168.33.10"

  config.vm.provision "shell", path: "docker.sh"
end
