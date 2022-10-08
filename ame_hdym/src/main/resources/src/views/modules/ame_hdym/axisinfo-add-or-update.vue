<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="vel1">
      <el-input v-model="dataForm.vel1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="vel2">
      <el-input v-model="dataForm.vel2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="vel3">
      <el-input v-model="dataForm.vel3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="vel4">
      <el-input v-model="dataForm.vel4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="vel5">
      <el-input v-model="dataForm.vel5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="vel6">
      <el-input v-model="dataForm.vel6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="velx1">
      <el-input v-model="dataForm.velx1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current1">
      <el-input v-model="dataForm.current1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current2">
      <el-input v-model="dataForm.current2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current3">
      <el-input v-model="dataForm.current3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current4">
      <el-input v-model="dataForm.current4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current5">
      <el-input v-model="dataForm.current5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current6">
      <el-input v-model="dataForm.current6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="currentx1">
      <el-input v-model="dataForm.currentx1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="torque1">
      <el-input v-model="dataForm.torque1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="torque2">
      <el-input v-model="dataForm.torque2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="torque3">
      <el-input v-model="dataForm.torque3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="torque4">
      <el-input v-model="dataForm.torque4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="torque5">
      <el-input v-model="dataForm.torque5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="torque6">
      <el-input v-model="dataForm.torque6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="torquex1">
      <el-input v-model="dataForm.torquex1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power1">
      <el-input v-model="dataForm.power1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power2">
      <el-input v-model="dataForm.power2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power3">
      <el-input v-model="dataForm.power3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power4">
      <el-input v-model="dataForm.power4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power5">
      <el-input v-model="dataForm.power5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power6">
      <el-input v-model="dataForm.power6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="powerx1">
      <el-input v-model="dataForm.powerx1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          vel1: '',
          vel2: '',
          vel3: '',
          vel4: '',
          vel5: '',
          vel6: '',
          velx1: '',
          current1: '',
          current2: '',
          current3: '',
          current4: '',
          current5: '',
          current6: '',
          currentx1: '',
          torque1: '',
          torque2: '',
          torque3: '',
          torque4: '',
          torque5: '',
          torque6: '',
          torquex1: '',
          power1: '',
          power2: '',
          power3: '',
          power4: '',
          power5: '',
          power6: '',
          powerx1: '',
          time: ''
        },
        dataRule: {
          vel1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          vel2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          vel3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          vel4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          vel5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          vel6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          velx1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          currentx1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          torque1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          torque2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          torque3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          torque4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          torque5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          torque6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          torquex1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          powerx1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/axisinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.vel1 = data.axisinfo.vel1
                this.dataForm.vel2 = data.axisinfo.vel2
                this.dataForm.vel3 = data.axisinfo.vel3
                this.dataForm.vel4 = data.axisinfo.vel4
                this.dataForm.vel5 = data.axisinfo.vel5
                this.dataForm.vel6 = data.axisinfo.vel6
                this.dataForm.velx1 = data.axisinfo.velx1
                this.dataForm.current1 = data.axisinfo.current1
                this.dataForm.current2 = data.axisinfo.current2
                this.dataForm.current3 = data.axisinfo.current3
                this.dataForm.current4 = data.axisinfo.current4
                this.dataForm.current5 = data.axisinfo.current5
                this.dataForm.current6 = data.axisinfo.current6
                this.dataForm.currentx1 = data.axisinfo.currentx1
                this.dataForm.torque1 = data.axisinfo.torque1
                this.dataForm.torque2 = data.axisinfo.torque2
                this.dataForm.torque3 = data.axisinfo.torque3
                this.dataForm.torque4 = data.axisinfo.torque4
                this.dataForm.torque5 = data.axisinfo.torque5
                this.dataForm.torque6 = data.axisinfo.torque6
                this.dataForm.torquex1 = data.axisinfo.torquex1
                this.dataForm.power1 = data.axisinfo.power1
                this.dataForm.power2 = data.axisinfo.power2
                this.dataForm.power3 = data.axisinfo.power3
                this.dataForm.power4 = data.axisinfo.power4
                this.dataForm.power5 = data.axisinfo.power5
                this.dataForm.power6 = data.axisinfo.power6
                this.dataForm.powerx1 = data.axisinfo.powerx1
                this.dataForm.time = data.axisinfo.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/axisinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'vel1': this.dataForm.vel1,
                'vel2': this.dataForm.vel2,
                'vel3': this.dataForm.vel3,
                'vel4': this.dataForm.vel4,
                'vel5': this.dataForm.vel5,
                'vel6': this.dataForm.vel6,
                'velx1': this.dataForm.velx1,
                'current1': this.dataForm.current1,
                'current2': this.dataForm.current2,
                'current3': this.dataForm.current3,
                'current4': this.dataForm.current4,
                'current5': this.dataForm.current5,
                'current6': this.dataForm.current6,
                'currentx1': this.dataForm.currentx1,
                'torque1': this.dataForm.torque1,
                'torque2': this.dataForm.torque2,
                'torque3': this.dataForm.torque3,
                'torque4': this.dataForm.torque4,
                'torque5': this.dataForm.torque5,
                'torque6': this.dataForm.torque6,
                'torquex1': this.dataForm.torquex1,
                'power1': this.dataForm.power1,
                'power2': this.dataForm.power2,
                'power3': this.dataForm.power3,
                'power4': this.dataForm.power4,
                'power5': this.dataForm.power5,
                'power6': this.dataForm.power6,
                'powerx1': this.dataForm.powerx1,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
