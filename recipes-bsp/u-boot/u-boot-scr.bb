SUMMARY = "U-Boot boot script (boot.scr) for Raspberry Pi 4"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://boot.cmd"
S = "${WORKDIR}"

do_compile() {
    uboot-mkimage -A arm64 -O linux -T script -C none -d "${WORKDIR}/boot.cmd" "${B}/boot.scr"
}

do_install() {
    :
}

inherit deploy

do_deploy() {
    install -d "${DEPLOYDIR}"
    install -m 0644 "${B}/boot.scr" "${DEPLOYDIR}/boot.scr"
}

addtask deploy before do_build after do_compile

COMPATIBLE_MACHINE = "(raspberrypi4-64)"
