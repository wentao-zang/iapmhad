<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="ת˙èr/min)" prop="rotvel">
      <el-input v-model="dataForm.rotvel" placeholder="ת˙èr/min)"></el-input>
    </el-form-item>
    <el-form-item label="˙ֈ(mm/min)" prop="vel">
      <el-input v-model="dataForm.vel" placeholder="˙ֈ(mm/min)"></el-input>
    </el-form-item>
    <el-form-item label="λփ(mm)" prop="pos">
      <el-input v-model="dataForm.pos" placeholder="λփ(mm)"></el-input>
    </el-form-item>
    <el-form-item label="΂ֈ" prop="temp">
      <el-input v-model="dataForm.temp" placeholder="΂ֈ"></el-input>
    </el-form-item>
    <el-form-item label="غԘ(KN)" prop="spload">
      <el-input v-model="dataForm.spload" placeholder="غԘ(KN)"></el-input>
    </el-form-item>
    <el-form-item label="էw(A)" prop="current">
      <el-input v-model="dataForm.current" placeholder="էw(A)"></el-input>
    </el-form-item>
    <el-form-item label="Ťޘ(Nm)" prop="torque">
      <el-input v-model="dataForm.torque" placeholder="Ťޘ(Nm)"></el-input>
    </el-form-item>
    <el-form-item label="٦(W)" prop="power">
      <el-input v-model="dataForm.power" placeholder="٦(W)"></el-input>
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
          rotvel: '',
          vel: '',
          pos: '',
          temp: '',
          spload: '',
          current: '',
          torque: '',
          power: '',
          time: ''
        },
        dataRule: {
          rotvel: [
            { required: true, message: 'ת˙èr/min)不能为空', trigger: 'blur' }
          ],
          vel: [
            { required: true, message: '˙ֈ(mm/min)不能为空', trigger: 'blur' }
          ],
          pos: [
            { required: true, message: 'λփ(mm)不能为空', trigger: 'blur' }
          ],
          temp: [
            { required: true, message: '΂ֈ不能为空', trigger: 'blur' }
          ],
          spload: [
            { required: true, message: 'غԘ(KN)不能为空', trigger: 'blur' }
          ],
          current: [
            { required: true, message: 'էw(A)不能为空', trigger: 'blur' }
          ],
          torque: [
            { required: true, message: 'Ťޘ(Nm)不能为空', trigger: 'blur' }
          ],
          power: [
            { required: true, message: '٦(W)不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ame_hdym/spinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.rotvel = data.spinfo.rotvel
                this.dataForm.vel = data.spinfo.vel
                this.dataForm.pos = data.spinfo.pos
                this.dataForm.temp = data.spinfo.temp
                this.dataForm.spload = data.spinfo.spload
                this.dataForm.current = data.spinfo.current
                this.dataForm.torque = data.spinfo.torque
                this.dataForm.power = data.spinfo.power
                this.dataForm.time = data.spinfo.time
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
              url: this.$http.adornUrl(`/ame_hdym/spinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'rotvel': this.dataForm.rotvel,
                'vel': this.dataForm.vel,
                'pos': this.dataForm.pos,
                'temp': this.dataForm.temp,
                'spload': this.dataForm.spload,
                'current': this.dataForm.current,
                'torque': this.dataForm.torque,
                'power': this.dataForm.power,
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
