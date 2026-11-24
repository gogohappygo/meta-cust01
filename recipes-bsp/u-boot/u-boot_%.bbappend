DEPENDS:append = " u-boot-mkenvimage-native"

# Match CONFIG_ENV_SIZE in U-Boot's .config (e.g., 0x4000 = 16 KiB)
UBOOT_ENV_SIZE ?= "0x4000"

do_compile:append() {
    if [ -f "${B}/u-boot-initial-env" ]; then
        uboot-mkenvimage -s ${UBOOT_ENV_SIZE} -o "${B}/uboot.env" "${B}/u-boot-initial-env"
    fi
}

do_deploy:append() {
    if [ -f "${B}/uboot.env" ]; then
        install -m 0644 "${B}/uboot.env" "${DEPLOYDIR}/uboot.env"
    fi
}
