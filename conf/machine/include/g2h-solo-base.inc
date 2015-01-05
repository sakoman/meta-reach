SOC_FAMILY = "mx6:mx6dl:g2h"

PREFERRED_PROVIDER_u-boot = "u-boot-g2h"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-g2h"
# this config puts the env on SD
UBOOT_MACHINE = "g2h_solo_sd_config"

PREFERRED_PROVIDER_virtual/kernel = "linux-g2h"
KERNEL_IMAGETYPE = "zImage"

SERIAL_CONSOLE = "115200 ttymxc0"

SIO_TTY = "/dev/ttymxc1"